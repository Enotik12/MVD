package snake.objects;

import Snake.SnakeGame;


public class Apple {
    
    //SnakeGame main;
    public int posX;
    public int posY;
    public Apple(int x, int y){
        posX=x;
        posY=y;
    }

    

   
  
    public void setRandomPosition(){
        posX=Math.abs((int) (Math.random()*SnakeGame.WIDTH-1));
        posY=Math.abs((int) (Math.random()*SnakeGame.HEIGHT-1));
        
    }
}
