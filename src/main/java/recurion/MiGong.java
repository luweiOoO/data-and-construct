package recurion;

public class MiGong {

    public static void main(String[] args){
        //先创建一个二维数组，模拟迷宫
        //地图
        int[][] map = new int[8][7];
        //使用1表示墙
        //先把上下全部置为1
        for(int i = 0; i < 7; i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        //左右全部置为1
        for(int i = 0;i < 8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //中间部分置为1
        for(int i = 1; i < 3; i++){
            map[3][i] = 1;
        }

        //输出地图
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        setWay2(map,1,1);
        System.out.println("--------------------------------");
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 7; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    //使用递归来给小球找路
    //i,j表示从地图哪个位置开始出发(1,1)
    //如果小球能到map[6][5]位置，则说明通路找到
    //判定，当map[i][j]为0表示该点没有走过，当为1表示墙，2表示通道可以走，3表示该点已经走过，但是走不通
    //在走迷宫时需要确定一个策略：下->右->上->左，若走不通，再回去
    /**
     *
     * @param map 表示地图
     * @param i 从哪个位置开始找
     * @param j
     * @return 如果找到通路就返回true，否则返回false
     */
    public static boolean setWay(int[][] map,int i, int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){ //如果当前节点还没有走过
                //按照策略 下->右->上->左 走
                map[i][j] = 2;//假定该点可以走通
                if(setWay(map,i+1,j)){//向下走
                    return true;
                }else if(setWay(map,i,j+1)){//向右走
                    return true;
                }else if(setWay(map, i-1 ,j)){//向上走
                    return true;
                }else if(setWay(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //如果map[i][j] != 0,可能是1，2，3
                return false;
            }
        }
    }

    //修改走路得策略，改成上->右->下->左

    public static boolean setWay2(int[][] map,int i, int j){
        if(map[6][5] == 2){
            return true;
        }else{
            if(map[i][j] == 0){ //如果当前节点还没有走过
                //按照策略 下->右->上->左 走
                map[i][j] = 2;//假定该点可以走通
                if(setWay2(map,i-1,j)){//向上走
                    return true;
                }else if(setWay2(map,i,j+1)){//向右走
                    return true;
                }else if(setWay2(map, i+1 ,j)){//向下走
                    return true;
                }else if(setWay2(map,i,j-1)){//向左走
                    return true;
                }else {
                    //说明该点走不通，是死路
                    map[i][j] = 3;
                    return false;
                }
            }else{
                //如果map[i][j] != 0,可能是1，2，3
                return false;
            }
        }
    }
}
