package snake;



public class Poison {
    
    
    public int posQ;
    public int posW;
  
    public Poison(int x, int y){
        posQ=x;
        posW=y;
    }

    

   
  
    public void setRandomPosition(){
        posQ=Math.abs((int) (Math.random()*SnakeGame.WIDTH-1));
        posW=Math.abs((int) (Math.random()*SnakeGame.HEIGHT-1));
        
    }
}
