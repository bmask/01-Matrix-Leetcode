package LTC;

public class Matrix01_Leetcode {
	
	 public static void main(String[] args) {
		 Matrix01_Leetcode object = new Matrix01_Leetcode();
	        object.run();

	    }
	 
	 void run() {
	       // int[][] matrix = {{1, 1, 0, 0, 1, 0, 0, 1, 1, 0}, {1, 0, 0, 1, 0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 0, 1, 1, 1, 1, 0}, {0, 1, 1, 1, 0, 1, 1, 1, 1, 1}, {0, 0, 1, 1, 1, 1, 1, 1, 1, 0}, {1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, {0, 1, 1, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0, 0, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0, 1, 1, 1, 1}};

	      //  int[][] matrix = {{1, 0, 1, 1, 0, 0, 1, 0, 0, 1}, {0, 1, 1, 0, 1, 0, 1, 0, 1, 1}, {0, 0, 1, 0, 1, 0, 0, 1, 0, 0}, {1, 0, 1, 0, 1, 1, 1, 1, 1, 1}, {0, 1, 0, 1, 1, 0, 0, 0, 0, 1}, {0, 0, 1, 0, 1, 1, 1, 0, 1, 0}, {0, 1, 0, 1, 0, 1, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 1, 1, 1, 0, 1}, {1, 1, 1, 1, 1, 1, 1, 0, 1, 0}, {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}};

	        int[][] matrix = {{1, 1, 1, 1, 1, 1, 0, 1, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 1, 1, 1}, {0, 1, 0, 1, 1, 1, 1, 0, 0, 0}, {1, 1, 1, 0, 0, 1, 1, 0, 1, 1}, {1, 0, 1, 1, 1, 0, 1, 1, 1, 1}, {1, 1, 0, 0, 1, 0, 1, 1, 1, 1}, {1, 0, 1, 0, 0, 0, 1, 1, 0, 1}, {1, 1, 0, 1, 1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 1, 1, 0, 1, 1, 1}};
	        updateMatrix(matrix);

	    }
	
    public int[][] updateMatrix(int[][] matrix) {

        if(matrix==null || matrix.length<1 || matrix[0].length<1)
            return matrix;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j]==1){
                    int result = Integer.MAX_VALUE;
                    matrix[i][j]=getDistance(matrix, i, j, 1, result);
                }
            }
        }
        System.out.println("===================================");
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println("");
        }

        return matrix;
    }

    int getDistance(int[][] matrix, int x, int y, int move, int result){

        if(x<move && y<move && x+move>=matrix.length && y+move>=matrix[0].length)
            return 0;



        int minX=Math.max(0,x-move);
        int maxX=Math.min(matrix.length-1, x+move);
        int minY=Math.max(0,y-move);
        int maxY=Math.min(matrix[0].length-1,y+move);

        boolean hitZero=false;

        for(int i=minX; i<=maxX; i++){
            if(matrix[i][minY]!=1)
                result = Math.min(result, Math.abs(x-i)+Math.abs(y-minY)+matrix[i][minY]);

            if(matrix[i][maxY]!=1)
                result = Math.min(result,Math.abs(x-i)+Math.abs(y-maxY)+matrix[i][maxY]);

            if(result==1)
                return result;

            if(matrix[i][maxY]==0 || matrix[i][minY]==0)
                hitZero=true;
        }

        for(int j=minY; j<=maxY; j++){
            if(matrix[minX][j]!=1)
                result = Math.min(result, Math.abs(x-minX)+Math.abs(y-j)+matrix[minX][j]);

            if(matrix[maxX][j]!=1)
                result = Math.min(result, Math.abs(x-maxX)+Math.abs(y-j)+matrix[maxX][j]);

            if(result==1)
                return result;

            if(matrix[minX][j]==0 || matrix[maxX][j]==0)
                hitZero=true;
        }

         if(hitZero && result<Integer.MAX_VALUE && result<=move)
             return result;



        return getDistance(matrix, x, y, ++move, result);
    }

}
