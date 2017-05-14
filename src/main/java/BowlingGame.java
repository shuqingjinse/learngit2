public class BowlingGame {

    public int getBowlingScore(String bowlingCode) {
        String s = bowlingCode.replace("|","");
		s = bowlingCode.replace("-","0");
		char[] begin = s.toCharArray();
		int ans = 0;
		int num = 0;
		int i = 0;
		while(num < 10){
			if(num==9){
				if(begin[i]=='X'){
					if(begin[i+1]=='X'){
						if(begin[i+2]=='X')
							ans = ans + 30;
						else
							ans = ans + 20 + Integer.parseInt(String.valueOf(begin[i+2]));
					}
					else if(begin[i+1]!='X' && begin[i+2]=='X')
						ans = ans + 20 + Integer.parseInt(String.valueOf(begin[i+1]));
					else
						ans = ans + 10 + Integer.parseInt(String.valueOf(begin[i+1])) + Integer.parseInt(String.valueOf(begin[i+2]));					
				}
				else if(begin[i]!='X' && begin[i+1]=='/'){
					if(begin[i+2]=='X'){
						ans = ans + 20;
					}
					else 
						ans = ans + 10 + Integer.parseInt(String.valueOf(begin[i+2]));
				}
				else 
					ans = ans + Integer.parseInt(String.valueOf(begin[i])) + Integer.parseInt(String.valueOf(begin[i+1]));
				num++;
			}
			if(num<9){
				if(begin[i]=='X'){
					if(begin[i+1]=='X'){
						if(begin[i+2]=='X')
							ans = ans + 30;
						else
							ans = ans + 20 + Integer.parseInt(String.valueOf(begin[i+2]));
					}
					else if(begin[i+1]!='X' && begin[i+2] =='/')
						ans = ans + 20 + Integer.parseInt(String.valueOf(begin[i+1]));
					else 
						ans = ans + 10 + Integer.parseInt(String.valueOf(begin[i+1])) + Integer.parseInt(String.valueOf(begin[i+2]));
					i++;
					num++;
				}
				if(begin[i]<='9' && begin[i]>='0'){
					if(begin[i+1]=='/')
						ans = ans + 10 + Integer.parseInt(String.valueOf(begin[i+2]));
					else
						ans = ans + Integer.parseInt(String.valueOf(begin[i])) + Integer.parseInt(String.valueOf(begin[i+1]));
					i = i + 2;
					num++;
				}	
			}			
		}
		return ans;
    }
}
