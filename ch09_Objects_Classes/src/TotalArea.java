public class TotalArea {
    public static void main(String[] args) {

    }

    /** Create an array of Circle objects */
    public static CircleWithPrivateDataFields[] createCircleArray() {
        CircleWithPrivateDataFields[] circleArray =
                new CircleWithPrivateDataFields[5];

        for (int i = 0; i < circleArray.length; i++) {
            circleArray[i] =
                    new CircleWithPrivateDataFields(Math.random() * 100);
        }

        // Return Circle aray
        return circleArray;
    }
}


