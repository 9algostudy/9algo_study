package 윤다은.week6;
import java.util.ArrayList;
import java.util.List;

class UserSolution {
	int N;
	int total;
	int[] parent;
	
	class Monarch {
		int x;
		int y;
		int num;
		char[] name;
		List<Integer> enemy = new ArrayList<>();
		
		public Monarch(int x, int y, int num, char[] name) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.name = name;
		}
	}
	
	Monarch[] monarchs;
	
    void init(int N, int mSoldier[][], char mMonarch[][][])
    {
    	this.N = N;
    	total = N*N;
    	parent = new int[total];
    	monarchs = new Monarch[total];
    	for (int i = 0; i < N; i++) {
    		for (int j = 0; j < N; j++) {
    			int n = i*N+j;
    			monarchs[n] = new Monarch(i, j, mSoldier[i][j], mMonarch[i][j]);
    			parent[n] = n;
    		}
    	}
    }
    void destroy()
    {
    	
    }
    int ally(char mMonarchA[], char mMonarchB[])
    {
    	if (checkName(mMonarchA, mMonarchB) == 1) return -1;
    	
    	int a=0, b=0;
    	for (int i = 0; i < total; i++) {
    		if (checkName(monarchs[i].name, mMonarchA) == 1) a = i;
    		else if (checkName(monarchs[i].name, mMonarchB) == 1) b = i;
    	}
    	
    	if (findP(a) == findP(b)) return -1;
    	for (int m : monarchs[parent[a]].enemy) {
    		if (m == b) return -2;
    	}
    	
    	union(a, b);
    	return 1;
    }
    int attack(char mMonarchA[], char mMonarchB[], char mGeneral[])
    {
    	int a = -1, b = -1;
    	for (int i = 0; i < N; i++) {
    		if (checkName(monarchs[i].name, mMonarchA) == 1) a = i;
    		else if (checkName(monarchs[i].name, mMonarchB) == 1) b = i;
    	}
    	
    	if (findP(a) == findP(b)) return -1;
    	
    	
    	
        return -3;
    }
    int recruit(char mMonarch[], int mNum, int mOption)
    {
    	
    	int p = -1, cur = -1;
    	for (int i = 0; i < N; i++) {
    		if (checkName(mMonarch, monarchs[i].name) == 1) {
    			p = findP(i);
    			cur = i;
    			break;
    		}
    	}
    	
    	int cnt = 0;
    	if (mOption == 1) {
        	for (int i = 0; i < N; i++) {
        		if (p == findP(i)) {
        			monarchs[i].num += mNum;
        			cnt += monarchs[i].num;
        		}
        	}
    	} else {
    		monarchs[cur].num += mNum;
    		cnt = monarchs[cur].num;
    	}
    	
        return cnt;
    }
    
    int checkName(char a[], char b[]) {
    	int lenA = a.length;
    	int lenB = b.length;
    	
    	if (lenA == lenB) {
    		for (int i = 0; i <= lenA; i++) {
    			if (a[i] != b[i]) {
    				return 0;
    			}
    		}
    		return 1;
    	}
    	return 0;
    }
    
    int findP(int n) {
    	if (parent[n] == n) return n;
    	return parent[n] = findP(parent[n]);
    }
    
    void union(int a, int b) {
    	int n = parent[a];
    	parent[n] = parent[b];
    	for (int i : monarchs[parent[b]].enemy) {
    		monarchs[n].enemy.add(i);
    	}
    }
}