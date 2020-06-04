
/**
 * 稀疏数组的实现与应用
 */
public class SparseArray {


    public static void main(String[] args){

        //初始化一个11*11的棋盘，0代表空 1代表黑子，2代表白子
        int[][] myArray = new int[11][11];
        myArray[0][1] = 1;
        myArray[1][2] = 2;
        myArray[3][5] = 1;

        printArray(myArray);

        //TODO 将该棋盘数组转换为稀疏数组存储
        int[][] sparseArray = toSparseArray(myArray);
        System.out.println("-----------------------------");

        printArray(sparseArray);
        //TODO 将稀疏数组转换为棋盘数组

        int[][] newArray = toArray(sparseArray);
        printArray(newArray);

        System.out.println("稀疏数组长度威: " + sparseArray.length);
    }

    //将棋盘数组转换为稀疏数组
    private static int[][] toSparseArray(int[][] myArray){
        int count = 0;
        for(int[] row : myArray){
            for(int element : row){
                if (element != 0){
                    count += 1;
                }
            }
        }
        int[][] sparseArray = new int[count+1][3];
        sparseArray[0][0] = myArray.length;
        sparseArray[0][1] = myArray.length;
        sparseArray[0][2] = count;
        int num = 1;
        for(int i = 0; i < myArray.length; i++){
            for(int j = 0;j < myArray.length; j++){
                if(myArray[i][j] != 0){
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = myArray[i][j];
                    num += 1;
                }
            }
        }
        return sparseArray;
    }

    //打印数组
    private static void printArray(int[][] array){
        for(int[] row : array){
            for (int element : row){
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }

    //将稀疏数组转换为正常数组
    private static int[][] toArray(int[][] sparseArray){

        int[][] array = new int[sparseArray[0][0]][sparseArray[0][1]];

        for(int i = 1; i < sparseArray.length; i++){
            array[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        return array;
    }
}
