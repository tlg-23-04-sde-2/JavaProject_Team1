package com.memmatch;

class Board {
    playGame();         //controller
    showIntro();        //controller
    clearBoard();       //board method
    setUpBoard();       //board method
    while(!gameOver());  //player Method (if player life == 0) game over return true
    drawBoard();        //board method
    prompPlayerForGuess();       //player method -- if validGuess = true; nextLevel();
    //win() false
    reloadLevel();
    win();              //controller
}