package com.example;

import static java.util.Objects.nonNull;

public class StudyInterfaceCoreFeatures {

	public static void main(String[] args) {
		A a = new C();
		// System.out.println(a instanceof B);
		System.out.println(a instanceof K);
        if(a instanceof C) { // guard
        	C c = (C) a; // safe
        	if (nonNull(c) && c.fun())
        	   System.out.println(c);
        }
        if (a instanceof C c && nonNull(c) && c.fun()) {
        	System.out.println(c);        	
        }
	}

}

class G {
	int x;
}

class A extends G {
}

class B extends G {
}

class C extends A {
	public boolean fun() {
		return true;
	}
} // single

abstract interface K {
	public static final int x = 42;
}

interface L {
	int gun();
    default int fun() { // java se 8
    	return run();
    }
    static int sun() { // java se 8
    	return tun();
    }
    private int run() { // java se 9
    	return 42;
    }
    
    private static int tun() { // java se 9
    	return 42;
    }
}

interface M extends K, L {
} // multiple

class F extends A implements K, L {

	@Override
	public int gun() {
		// TODO Auto-generated method stub
		return 0;
	}
} // multiple

class H implements L {

	@Override
	public int gun() {
		return 0;
	}

}

interface P {
	default int fun() { return 42;}
}
interface Q {
	default int fun() { return 42;}
}
class W implements P,Q {

	@Override
	public int fun() {
		return 42;
	}
	
}