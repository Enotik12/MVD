package snake;



public class Poison {
    
    
    public int posB;
    public int posC;
  
    public Poison(int x, int y){
        posB=x;
        posC=y;
    }

    

   
  
    public void setRandomPosition(){
        posB=Math.abs((int) (Math.random()*SnakeGame.WIDTH-1));
        posC=Math.abs((int) (Math.random()*SnakeGame.HEIGHT-1));
        
    }
}
