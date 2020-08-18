package com.笔试.bigo;

import java.util.ArrayList;
import java.util.List;

/**
 * @DESC
 * @CREATE BY @Author pbj on @Date 2020/8/18 19:43
 */
public class Main1 {
    public static String calLoad(String param){
        String[] input = param.split(" ");
        int totalDisk = Integer.parseInt(input[0]);
        int totalMemery = Integer.parseInt(input[1]);
        List<Serve> serves = getServes(input[2].split("#"));
        Result result  = process(totalDisk, totalMemery, serves);
        double diskUse = (double)result.getDiskUse() / totalDisk;
        double menUse = (double)result.getMemUse() / totalMemery;
        return result.getUsers() + "," + diskUse + "," + menUse;
    }

    private static Result process(int totalDisk, int totalMemery, List<Serve> serves) {
        if(serves.isEmpty()){
            return new Result(0,0,0);
        }
        int cdisk = serves.get(0).getDisk();
        int cmem = serves.get(0).getMem();
        int cuser = serves.get(0).getUser();
        serves.remove(0);
        if(cdisk <= totalDisk && cmem <= totalMemery){
            List<Serve> list1 = new ArrayList<>(serves);
            Result res1 = process(totalDisk - cdisk, totalMemery - cmem, list1);
            res1.setUsers(res1.getUsers() + cuser);
            res1.setDiskUse(cdisk + res1.getDiskUse());
            res1.setMemUse(cmem + res1.getMemUse());
            List<Serve> list2 = new ArrayList<>(serves);
            Result res2 = process(totalDisk, totalMemery, list2);
            return res1.getUsers() > res2.getUsers() ? res1 : res2;
        }else{
            List<Serve> list3 = new ArrayList<>(serves);
            return process(totalDisk,totalMemery,serves);
        }
    }

    public static List<Serve> getServes(String[] str){
        List<Serve> serveList = new ArrayList<>();
        for(int i = 0; i < str.length; i++){
            String[] servrs = str[i].split(",");
            serveList.add(new Serve(Integer.parseInt(servrs[0]), Integer.parseInt(servrs[1]), Integer.parseInt(servrs[2])));
        }
        return serveList;
    }

    static class Result{
        private int users;
        private int diskUse;
        private int memUse;

        public Result(int users, int diskUse, int memUse) {
            this.users = users;
            this.diskUse = diskUse;
            this.memUse = memUse;
        }

        public int getUsers() {
            return users;
        }

        public void setUsers(int users) {
            this.users = users;
        }

        public int getDiskUse() {
            return diskUse;
        }

        public void setDiskUse(int diskUse) {
            this.diskUse = diskUse;
        }

        public int getMemUse() {
            return memUse;
        }

        public void setMemUse(int memUse) {
            this.memUse = memUse;
        }
    }

    static class Serve{
        private int disk;
        private int mem;
        private int user;

        public Serve(int disk, int mem, int users){
            this.disk = disk;
            this.mem = mem;
            this.user = users;
        }

        public int getDisk() {
            return disk;
        }

        public void setDisk(int disk) {
            this.disk = disk;
        }

        public int getMem() {
            return mem;
        }

        public void setMem(int mem) {
            this.mem = mem;
        }

        public int getUser() {
            return user;
        }

        public void setUser(int user) {
            this.user = user;
        }
    }
}
