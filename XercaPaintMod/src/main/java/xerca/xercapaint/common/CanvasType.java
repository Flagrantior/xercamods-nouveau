package xerca.xercapaint.common;


public enum CanvasType {
    SMALL, TALL, LONG, LARGE, X3Y2, X3Y3, X4Y2, X4Y3, X4Y4;

    public static CanvasType fromByte(byte x) {
        return switch (x) {
            case 0 -> SMALL;
            case 1 -> TALL;
            case 2 -> LONG;
            case 3 -> LARGE;
            case 4 -> X3Y2;
            case 5 -> X3Y3;
            case 6 -> X4Y2;
            case 7 -> X4Y3;
            case 8 -> X4Y4;
            default -> null;
        };
    }

    public static int getWidth(CanvasType canvasType){
        return switch (canvasType) {
            case SMALL, TALL -> 16;
            case LONG, LARGE -> 32;
            case X3Y2, X3Y3 -> 48;
            case X4Y2, X4Y3, X4Y4 -> 64;
        };
    }

    public static int getHeight(CanvasType canvasType){
        return switch (canvasType) {
            case SMALL, LONG -> 16;
            case TALL, LARGE, X3Y2, X4Y2 -> 32;
            case X3Y3, X4Y3 -> 48;
            case X4Y4 -> 64;
        };
    }
}
