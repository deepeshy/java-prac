import java.util.Scanner;

public class QueenAttack {

    private static long countPositions(long rQueen, long cQueen, long n) {
        long positionCount = 2 * n - 2; // initialized with horizontal position count
        long leftOffset = cQueen - 1;
        long topOffset = n - rQueen;
        long bottomOffset = rQueen - 1;
        long rightOffset = n - cQueen;

        long topLeftCount = topOffset > leftOffset ? leftOffset : topOffset;// top left
        long topRightCount = topOffset > rightOffset ? rightOffset : topOffset;// top right
        long bottomLeftCount = bottomOffset > leftOffset ? leftOffset : bottomOffset;// bottom left
        long bottomRightCount = bottomOffset > rightOffset ? rightOffset : bottomOffset;// bottom right
        positionCount = positionCount + topLeftCount + topRightCount + bottomLeftCount + bottomRightCount;
        return positionCount;
    }

    private static class Coordinate {
        private long R;
        private long C;

        public long getR() {
            return R;
        }

        public long getC() {
            return C;
        }

        public Coordinate(long rObstacle, long cObstacle) {
            this.R = rObstacle;
            this.C = cObstacle;
        }

        @Override
        public String toString() {
            return R + "," + C;
        }
    }

    private static Coordinate pickCloserToPoint(long rQueen, long cQueen, Coordinate a, Coordinate b) {
        if (a == null && b == null) throw new IllegalArgumentException("invalid positions being compared");
        if (a == null) return b;
        if (b == null) return a;
        long aDist = Math.abs(rQueen - a.getR()) + Math.abs(cQueen - a.getC());
        long bDist = Math.abs(rQueen - b.getR()) + Math.abs(cQueen - b.getC());
        return aDist < bDist ? a : b;
    }

    private static long blockedPositions(long rQueen, long cQueen, long n, Coordinate[] obstacles) {
        long blockedPositions = 0;

        Coordinate effObstTopVert = null;
        Coordinate effObstBottomVert = null;
        Coordinate effObstLeftHoriz = null;
        Coordinate effObstRightHoriz = null;

        Coordinate effObstTopRight = null;
        Coordinate effObstTopLeft = null;
        Coordinate effObstBottomLeft = null;
        Coordinate effObstBottomRight = null;

        for (int i = 0; i < obstacles.length; i++) {

            long rObst = obstacles[i].getR();
            long cObst = obstacles[i].getC();

            if (rQueen == rObst && cQueen < cObst) { // right part of horizontal line through queen
                effObstRightHoriz = pickCloserToPoint(rQueen, cQueen, effObstRightHoriz, obstacles[i]);
            }

            if (rQueen == rObst && cQueen > cObst) { // left part of horizontal line through queen
                effObstLeftHoriz = pickCloserToPoint(rQueen, cQueen, effObstLeftHoriz, obstacles[i]);
            }

            if (cQueen == obstacles[i].getC() && rQueen < rObst) { // top part of vertical line
                effObstTopVert = pickCloserToPoint(rQueen, cQueen, effObstTopVert, obstacles[i]);
            }

            if (cQueen == obstacles[i].getC() && rQueen > rObst) { // bottom part of vertical line
                effObstBottomVert = pickCloserToPoint(rQueen, cQueen, effObstBottomVert, obstacles[i]);
            }

            if ((rQueen - rObst == cQueen - cObst) && rQueen > rObst) { // bottom left
                effObstBottomLeft = pickCloserToPoint(rQueen, cQueen, effObstBottomLeft, obstacles[i]);
            }

            if ((rQueen - rObst == cQueen - cObst) && rQueen < rObst) { // top right
                effObstTopRight = pickCloserToPoint(rQueen, cQueen, effObstTopRight, obstacles[i]);
            }

            if ((cObst - cQueen == rQueen - rObst) && rObst > rQueen) { // top left
                effObstTopLeft = pickCloserToPoint(rQueen, cQueen, effObstTopLeft, obstacles[i]);
            }

            if ((cObst - cQueen == rQueen - rObst) && rObst < rQueen) { // bottom right
                effObstBottomRight = pickCloserToPoint(rQueen, cQueen, effObstBottomRight, obstacles[i]);
            }
        }

        // Calculate number of positions that will no longer be attack-able
        if (effObstTopVert != null) {
            blockedPositions += 1 + n - effObstTopVert.getR();
        }
        if (effObstBottomVert != null) {
            blockedPositions += effObstBottomVert.getR();
        }
        if (effObstLeftHoriz != null) {
            blockedPositions += effObstLeftHoriz.getC();
        }
        if (effObstRightHoriz != null) {
            blockedPositions += 1 + n - effObstRightHoriz.getC();
        }

        if (effObstTopRight != null) {
            blockedPositions += (1 + n - effObstTopRight.getR()) > (1 + n - effObstTopRight.getC()) ? (1 + n - effObstTopRight.getC()) : (1 + n - effObstTopRight.getR());
        }
        if (effObstTopLeft != null) {
            long distanceFromEdge = (n + 1 - effObstTopLeft.getR()) > effObstTopLeft.getC() ? effObstTopLeft.getC() : (n + 1 - effObstTopLeft.getR());
            blockedPositions += distanceFromEdge;
        }
        if (effObstBottomLeft != null) {
            blockedPositions += effObstBottomLeft.getR() > effObstBottomLeft.getC() ? effObstBottomLeft.getC() : effObstBottomLeft.getR();
        }
        if (effObstBottomRight != null) {
            long distanceFromEdge = effObstBottomRight.getR() > (n + 1 - effObstBottomRight.getC()) ? (n + 1 - effObstBottomRight.getC()) : effObstBottomRight.getR();
            blockedPositions += distanceFromEdge;
        }
        return blockedPositions;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();
        Coordinate[] obstArr = new Coordinate[k];
        for (int a0 = 0; a0 < k; a0++) {
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            obstArr[a0] = new Coordinate(rObstacle, cObstacle);
            // your code goes here
        }
        System.out.println(countPositions(rQueen, cQueen, n) - blockedPositions(rQueen, cQueen, n, obstArr));
    }
}
