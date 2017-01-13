
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;


/**
 * Created by Khalin on 11/25/2016.
 */
public class Main {

    public static void initialize(String fileName) {
        PlyBoard plyBoard = new PlyBoard();
        RandomAccessFile plyBoardFile = null;
        try {
            plyBoardFile = new RandomAccessFile(new File(fileName), "rw");
            try {
                for (int count = 1; count < 100; count++)
                plyBoardFile.seek((count - 1) * (4 + (25 * 2) + 4 + 4 + 4 + 4));
                plyBoardFile.writeInt(plyBoard.getCode());
                plyBoardFile.writeUTF(plyBoard.getName());
                plyBoardFile.writeFloat(plyBoard.getUnitCost());
                plyBoardFile.writeFloat(plyBoard.getLength());
                plyBoardFile.writeFloat(plyBoard.getWidth());
                plyBoardFile.writeFloat(plyBoard.getThickness());
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        } catch (FileNotFoundException ef) {
            ef.printStackTrace();
        } finally {
            try {
                plyBoardFile.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }

    public static void writeRecord(PlyBoard plyBoard) {
        RandomAccessFile plyBoardFile = null;
        try {
            plyBoardFile = new RandomAccessFile(new File("stock-room.dbz"), "rw");
            try {
                plyBoardFile.seek((plyBoard.getCode() - 1) * (4 + (25 * 2) + 4 + 4 + 4 + 4));
                plyBoardFile.writeInt(plyBoard.getCode());
                plyBoardFile.writeUTF(plyBoard.getName());
                plyBoardFile.writeFloat(plyBoard.getUnitCost());
                plyBoardFile.writeFloat(plyBoard.getLength());

                plyBoardFile.writeFloat(plyBoard.getWidth());
                plyBoardFile.writeFloat(plyBoard.getThickness());

            } catch (IOException exc) {
                exc.printStackTrace();
            }
        } catch (FileNotFoundException ef) {
            ef.printStackTrace();
        } finally {
            try {
                plyBoardFile.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
    }

    public static PlyBoard readRecord(int code) {
        PlyBoard plyBoard = null;
        RandomAccessFile plyBoardFile = null;
        try {
            plyBoard = new PlyBoard();
            plyBoardFile = new RandomAccessFile(new File("stock-room.dbz"), "r");
            try {
                plyBoardFile.seek((code - 1) * (4 + (25 * 2) + 4 + 4 + 4 + 4));
                plyBoard.setCode(plyBoardFile.readInt());
                plyBoard.setName(plyBoardFile.readUTF());
                plyBoard.setUnitCost(plyBoardFile.readFloat());
                plyBoard.setLength(plyBoardFile.readFloat());
                plyBoard.setWidth(plyBoardFile.readFloat());
                plyBoard.setThickness(plyBoardFile.readFloat());
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        } catch (FileNotFoundException ef) {
            ef.printStackTrace();
        } finally {
            try {
                plyBoardFile.close();
            } catch (IOException exc) {
                exc.printStackTrace();
            }
        }
        return plyBoard;
    }

    public static void showRecord(Product product) {
        System.out.println(product);
    }

    public static void main(String[] args) {
        PlyBoard plyBoard = new PlyBoard(2, "Plyboard", 100, 10, 20, 3);
        PlyBoard Mahogony = new PlyBoard(3, "Mahogony", 4000, 30, 50, 2);
        PlyBoard Beechwood = new PlyBoard(4, "Beechwood", 2000, 20, 10, 4);
        PlyBoard Plywood = new PlyBoard(7, "Plywood", 1000, 60, 20, 1);
        PlyBoard Board = new PlyBoard(9, "Board", 500, 100, 400, 4);

        showRecord(plyBoard);
        showRecord(Mahogony);
        showRecord(Beechwood);
        showRecord(Plywood);
        showRecord(Board);

        initialize("stock-room.dbz");

        writeRecord(plyBoard);
        writeRecord(Mahogony);
        writeRecord(Beechwood);
        writeRecord(Plywood);
        writeRecord(Board);

        if (readRecord(4).getCode() == 0) {
            System.out.println("Record not found\n");
        } else {
            System.out.println(readRecord(4));
        }

    }
}