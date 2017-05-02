package com.mxuan.acm.bestcoder.b93.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by wangwenxuan on 2017/4/17.
 */
public class Main{

    static StreamTokenizer in;

    static int nextInt() throws IOException{
        in.nextToken();
        return (int) in.nval;
    }

    public static void main(String[] args) throws Exception{
        in = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
        int T = nextInt();
        while(T-- > 0){
            int n = nextInt();
            Set<Integer> s = new HashSet<Integer>();
            int result = 1;
            for(int i = 0; i < n; ++i){
                int a = nextInt();
                if(s.contains(a)){
                    s.clear();
                    result++;
                }
                s.add(a);
            }
            System.out.println(result);
        }
    }
}
