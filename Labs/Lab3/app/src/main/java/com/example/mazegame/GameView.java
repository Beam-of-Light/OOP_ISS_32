package com.example.mazegame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import com.example.mazegame.model.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class GameView extends View {
    private enum  Direction{
        UP, DOWN, LEFT, RIGHT
    }
    private static Cell[][] cells;
    private static Cell player;
    private static Cell exit;
    private static final int COLS = 7;
    private static final int ROWS = 11;
    private static final float WALL_THICKNESS = 4;
    private float cellSize, hMargin, vMargin;
    private Paint wallPaint, playerPaint, exitPaint;
    private static Random random = new Random();

    public GameView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        wallPaint = new Paint();
        wallPaint.setColor(Color.BLACK);
        wallPaint.setStrokeWidth(WALL_THICKNESS);

        playerPaint = new Paint();
        playerPaint.setColor(0xFFFFA500);   // Orange

        exitPaint = new Paint();
        exitPaint.setColor(Color.GREEN);

        createMaze();
    }

    public static void createMaze() {
        Stack<Cell> stack = new Stack<>();
        Cell current, next;

        cells = new Cell[COLS][ROWS];
        for(int x = 0; x < COLS; ++x) {
            for(int y = 0; y < ROWS; ++y) {
                cells[x][y] = new Cell(x, y);
            }
        }

        player = cells[0][0];
        exit = cells[COLS-1][ROWS-1];

        current = cells[0][0];
        current.visited = true;

        do {
            next = getNeighbour(cells, current);
            if (next!=null) {
                removeTheWall(current, next);
                stack.push(current);
                current = next;
                current.visited = true;
            } else {
                current = stack.pop();
            }
        } while (!stack.empty());

    }

    public static void removeTheWall(Cell current, Cell next) {
        // current up next
        if (current.col == next.col && current.row == next.row + 1) {
            current.topWall = false;
            next.bottomWall = false;
        }

        // current down next
        if (current.col == next.col && current.row == next.row - 1) {
            current.bottomWall = false;
            next.topWall = false;
        }

        // current left next
        if (current.col == next.col+1 && current.row == next.row) {
            current.leftWall = false;
            next.rightWall = false;
        }

        // current right next
        if (current.col == next.col - 1 && current.row == next.row) {
            current.rightWall = false;
            next.leftWall = false;
        }
    }

    public static Cell getNeighbour(Cell[][] cells, Cell cell) {
        List<Cell> neighbours = new ArrayList<>();

        // left neighbour
        if (cell.col > 0) {
            if (!cells[cell.col - 1][cell.row].visited) {
                neighbours.add(cells[cell.col - 1][cell.row]);
            }
        }

        // right neighbour
        if (cell.col < COLS-1) {
            if (!cells[cell.col + 1][cell.row].visited) {
                neighbours.add(cells[cell.col + 1][cell.row]);
            }
        }

        // top neighbour
        if (cell.row > 0) {
            if (!cells[cell.col][cell.row - 1].visited) {
                neighbours.add(cells[cell.col][cell.row - 1]);
            }
        }

        // bottom neighbour
        if (cell.row < ROWS-1) {
            if (!cells[cell.col][cell.row + 1].visited) {
                neighbours.add(cells[cell.col][cell.row + 1]);
            }
        }

        if (neighbours.size() > 0) {
            int index = random.nextInt(neighbours.size());
            return neighbours.get(index);
        }
        return null;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(0xFA5FAABF);   // Blue
        int width = getWidth();
        int height = getHeight();

        if (width/height < COLS/ROWS)
            cellSize = height / (ROWS + 1);
        else
            cellSize = width / (COLS + 1);

        hMargin = (width - COLS * cellSize) / 2;
        vMargin = (height - ROWS * cellSize) / 2;


        canvas.translate(hMargin, vMargin);

        for (int x = 0; x < COLS; ++x) {
            for (int y = 0; y < ROWS; ++y) {
               if (cells[x][y].topWall) {
                   canvas.drawLine(
                           x * cellSize,
                           y * cellSize,
                           (x + 1) * cellSize,
                           y * cellSize,
                           wallPaint
                   );
               }

               if (cells[x][y].leftWall) {
                   canvas.drawLine(
                           x * cellSize,
                           y * cellSize,
                           x * cellSize,
                           (y + 1) * cellSize,
                           wallPaint
                   );
               }
               if (cells[x][y].bottomWall) {
                   canvas.drawLine(
                           x * cellSize,
                           (y + 1) * cellSize,
                           (x + 1) * cellSize,
                           (y + 1) * cellSize,
                           wallPaint
                   );
               }
               if (cells[x][y].rightWall) {
                   canvas.drawLine(
                           (x + 1) * cellSize,
                           y * cellSize,
                           (x + 1) * cellSize,
                           (y + 1) * cellSize,
                           wallPaint
                   );
               }
            }
        }

        float margin = cellSize / 10;

        canvas.drawRect(
                player.col * cellSize + margin,
                player.row * cellSize + margin,
                (player.col + 1) * cellSize - margin,
                (player.row + 1) * cellSize - margin,
                playerPaint);

        canvas.drawRect(
                exit.col * cellSize + margin,
                exit.row * cellSize + margin,
                (exit.col + 1) * cellSize - margin,
                (exit.row + 1) * cellSize - margin,
                exitPaint);
    }

    public void movePlayer(Direction direction){
        switch (direction) {
            case UP:
                if (!player.topWall)
                    player = cells[player.col][player.row - 1];
                break;
            case DOWN:
                if (!player.bottomWall)
                    player = cells[player.col][player.row + 1];
                break;
            case LEFT:
                if (!player.leftWall)
                    player = cells[player.col - 1][player.row];
                break;
            case RIGHT:
                if (!player.rightWall)
                    player = cells[player.col + 1][player.row];
                break;
        }
        checkExit();
        invalidate(); //calls unDraw() ASAP
    }

    public void checkExit() {
        if (player == exit) {
            createMaze();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN)
            return true;
        if (event.getAction() == MotionEvent.ACTION_MOVE) {
            float x = event.getX();
            float y = event.getY();

            float playerCenterX = hMargin + (player.col + 0.5f) * cellSize;
            float playerCenterY = vMargin + (player.row + 0.5f) * cellSize;

            float dx = x - playerCenterX;
            float dy = y - playerCenterY;

            float absDX = Math.abs(dx);
            float absDY = Math.abs(dy);

            if (absDX > cellSize || absDY > cellSize ){
                if (absDX > absDY){
                    // move in x-direction
                    if (dx > 0) {
                        movePlayer(Direction.RIGHT);
                    } else {
                        movePlayer(Direction.LEFT);
                    }
                } else {
                    // move in y-direction
                    if (dy > 0) {
                        movePlayer(Direction.DOWN);
                    } else {
                        movePlayer(Direction.UP);
                    }
                }
            }
            return true;
        }
        return super.onTouchEvent(event);
    }
}
