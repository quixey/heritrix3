package org.archive.io;

import java.util.HashMap;
import java.util.Stack;

public class BufferPool{

    private static HashMap<Integer, Stack<byte[]>> pool = new HashMap<Integer, Stack<byte[]>>();

    public static byte[] pop(int n){
	synchronized(pool){
	    Stack<byte[]> list = pool.get(n);
	    if (list == null || list.size() == 0){
		return new byte[n];
	    }
	    else{
		return list.pop();		
	    }
	}
    }

    public static void push(byte[] array){
	int n = array.length;
	synchronized(pool){
	    Stack<byte[]> list = pool.get(n);
	    if (list == null){
		list = new Stack<byte[]>();
		pool.put(n, list);
	    }
	    list.push(array);
	}
    }

}
