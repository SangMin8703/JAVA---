public class Method_16 {
	public static byte max( byte b1, byte b2, byte b3 ) {
		System.out.println("byte 타입의 max 메소드 호출!!!");
		byte b;
		
		if( b1 > b2 )
			b = b1;
		else
			b = b2;
		return b3 > b ? b3 : b;
	}
	public static short max( short s1, short s2, short s3 ) {
		System.out.println("short 타입의 max 메소드 호출!!!");
		short s;
		
		if( s1 > s2 )
			s = s1;
		else
			s = s2;
		return s3 > s ? s3 : s;
	}
	public static int max( int i1, int i2, int i3 ) {
		System.out.println("int 타입의 max 메소드 호출!!!");
		int i;
		
		if( i1 > i2 )
			i = i1;
		else
			i = i2;
		return i3 > i ? i3 : i;
	}
	public static long max( long l1, long l2, long l3 ) {
		System.out.println("long 타입의 max 메소드 호출!!!");
		long l;
		
		if( l1 > l2 )
			l = l1;
		else
			l = l2;
		return l3 > l ? l3 : l;
	}
	public static float max( float f1, float f2, float f3 ) {
		System.out.println("float 타입의 max 메소드 호출!!!");
		float f;
		
		if( f1 > f2 )
			f = f1;
		else
			f = f2;
		return f3 > f ? f3 : f;
	}
	public static double max( double d1, double d2, double d3 ) {
		System.out.println("double 타입의 max 메소드 호출!!!");
		double d;
		
		if( d1 > d2 )
			d = d1;
		else
			d = d2;
		return d3 > d ? d3 : d;
	}
	
	public static void main(String[] args) {
		System.out.println( max((byte)1, (byte)2, (byte)3) );
		System.out.println( max((short)1, (short)2, (short)3) );
		System.out.println( max(1, 2, 3) );
		System.out.println( max(1L, 2L, 3L) );
		System.out.println( max(1.1f, 2.2f, 3.2f) );
		System.out.println( max(1.1, 2.1, 3.1) );
		
	}

}






