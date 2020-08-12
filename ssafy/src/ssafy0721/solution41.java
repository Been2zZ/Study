package ssafy0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class solution41 {
static int T, N;
static int Answer;

public static void main(String[] args) throws IOException {

	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
   
    T=Integer.parseInt(br.readLine().trim());   
    StringTokenizer st=null;
    
    for (int t = 1; t <= T; t++) {
        N=Integer.parseInt(br.readLine().trim());   
        char[][] map=new char[N][N];
        for (int i = 0; i < N; i++) {
        	st=new StringTokenizer(br.readLine().trim());
            for (int j = 0; j < N; j++) {
//                map[i][j]=scann.next().charAt(0);//"W"->'W'
                map[i][j] = st.nextToken().trim().charAt(0);
            }
        }
        Answer=0;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                char robot=map[r][c];
                if(robot=='A'){
                    for (int k = c+1; k <N; k++) { //short circuit
                        if(map[r][k]=='A' || map[r][k]=='B'||
                                map[r][k]=='C'||map[r][k]=='W'){
                            break;
                        }else if(map[r][k]=='S'){
                            Answer++;
                        }
                    }
                }else if(robot=='B'){
                    //우
                    for(int k=c+1; k<N; k++){
                        if(map[r][k]=='A'||map[r][k]=='B'
                                ||map[r][k]=='C'||map[r][k]=='W'){
                            break;
                        }else if(map[r][k]=='S'){
                            Answer++;
                        }
                    }
                    //좌
                    for(int k=c-1; k>=0; k--){
                        if(map[r][k]=='A'||map[r][k]=='B'
                                ||map[r][k]=='C'||map[r][k]=='W'){
                            break;
                        }else if(map[r][k]=='S'){
                            Answer++;
                        }
                    }

                }else if(robot=='C'){
                    //우
                    for(int k=c+1; k<N; k++){
                        if(map[r][k]=='A'||map[r][k]=='B'
                                ||map[r][k]=='C'||map[r][k]=='W'){
                            break;
                        }else if(map[r][k]=='S'){
                            Answer++;
                        }
                    }
                    //좌
                    for(int k=c-1; k>=0; k--){
                        if(map[r][k]=='A'||map[r][k]=='B'
                                ||map[r][k]=='C'||map[r][k]=='W'){
                            break;
                        }else if(map[r][k]=='S'){
                            Answer++;
                        }
                    }
                    //하
                    for(int k=r+1; k<N; k++){
                        if(map[k][c]=='A'||map[k][c]=='B'||
                                map[k][c]=='C'||map[k][c]=='W'){
                            break;
                        }else if(map[k][c]=='S'){
                            Answer++;
                        }
                    }
                    //상
                    for(int k=r-1; k>=0; k--){
                        if(map[k][c]=='A'||map[k][c]=='B'||
                                map[k][c]=='C'||map[k][c]=='W'){
                            break;
                        }else if(map[k][c]=='S'){
                            Answer++;
                        }
                    }
                }
            }
        }
        //print(map);
        System.out.println("#"+t +" "+Answer);
    }
}
public static void print(char[][] cc){
    for (int i = 0; i < cc.length; i++) {
        for (int j = 0; j <cc[i].length; j++) {
            System.out.printf("%c ",cc[i][j]);
        }
        System.out.println();
    }
}
}
