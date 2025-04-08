package io;
import java.io.*;
import java.util.*;
public class IO_21 {
	public static void main(String[] args) {
		String strSrcFileName = 
				"C:\\work\\sources\\java\\Day_17\\src\\io\\IO_10.java";
		String strDescFileName = 
				"C:\\work\\sources\\java\\Day_17\\IO_10_Result.txt";
		
		// IO_10.java 파일의 문자 데이터를 입력받아
		// 해당 파일 내부에 존재하는 모든 단어의 사용횟수를 추출하고
		// IO_10_Result.txt 파일에 해당 결과를 출력하세요.
		// 예시
		// FileInputStream : 2 회 사용
		// BufferedInputStream : 2 회 사용
		
		HashMap<String, ArrayList<Integer>> map = new HashMap<>();
		
		FileReader fr;
		BufferedReader br;
		
		FileWriter fw;
		BufferedWriter bw;
		PrintWriter pw;
		
		try {
			fr = new FileReader(strSrcFileName);
			br = new BufferedReader(fr);
			
			String data;			
			while( (data = br.readLine()) != null ) {
				StringTokenizer st = new StringTokenizer(data, " ");
				
				ArrayList<Integer> list;
				while( st.hasMoreTokens() ) {
					String token = st.nextToken().trim();
					if( token.length() > 0 ) {
						// 단어가 추출된 상황
						//System.out.println(token);
						
						list = map.get(token);
						if( list == null )
							map.put(token, new ArrayList<Integer>());
						else {
							list.add(0);
							map.put(token, list);
						}						
					}
				}
			}
			
			br.close();
			
			fw = new FileWriter(strDescFileName);
			bw = new BufferedWriter(fw);
			pw = new PrintWriter(bw);
			
			Iterator<String> iter = map.keySet().iterator();
			while(iter.hasNext()) {
				String key = iter.next();
				int size = map.get(key).size() + 1;
				
				pw.printf("%s : %d 회 사용\n", key, size);
			}
			
			pw.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}










