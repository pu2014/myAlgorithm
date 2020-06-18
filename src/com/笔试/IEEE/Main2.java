import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int groups = scanner.nextInt();
            int[][] matrix = new int[groups][2];
            for (int i = 0; i < groups; i++) {
                for (int j = 0; j < 2; j++) {
                    matrix[i][j] = scanner.nextInt();
                }
            }
            Queue<Integer> q = new LinkedList<>();
            byte[] visited = new byte[matrix.length];
            int root = matrix[0][0];
            for(int i = 1; i < groups; i++){
                if(matrix[i][1] == root){
                    root = matrix[i][0];
                }
            }
            q.add(root);
            String res = "";
            int cur = 0;
            int left = 0;
            while(!q.isEmpty()){
                cur = q.poll();
                res += cur + " ";
                for(int i = 0; i < groups; i++){
                    if(cur == matrix[i][0]){
                        if(visited[i] == 0){
                            left = i;
                            q.offer(matrix[i][1]);
                            visited[i] = 1;
                        }else{
                            System.out.println("Not a tree");
                        }
                    }
                }
                for(int i = left + 1; i < groups; i++){
                    if(cur == matrix[i][0]){
                        if(visited[i] == 0){
                            q.offer(matrix[i][1]);
                            visited[i] = 1;
                        }else{
                            System.out.println("Not a tree");
                        }
                    }
                }
            }
            System.out.println(res);
        }
    }
}