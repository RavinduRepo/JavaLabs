public class Lab2 {
    public static void main(String[] args) {
        double value;
        try {
            // Parse the value from the first argument
            value = Double.parseDouble(args[0]);
        } catch (NumberFormatException e) {
            // Handle invalid numerical input
            System.out.println("Invalid value provided. Please provide a valid numerical value.");
            return;
        }

        // Create instances of geometric shapes based on the parsed value
        Circle circle = new Circle(value);
        Square square = new Square(value);
        Sphere sphere = new Sphere(value);
        Cube cube = new Cube(value);

        if (args.length >= 3) {
            // Notify if too many arguments are provided
            System.out.println("The number of arguments is too many.");
        } else if (args.length == 2 && (args[1].equals("mm") || args[1].equals("cm") || args[1].equals("m"))) {
            // Print answers if valid units are provided as the second argument
            printAnswers(value, circle.circleArea(), sphere.sphereArea(), square.squareArea(),
                    cube.cubeArea(), sphere.sphereVolume(), cube.cubeVolume(), args[1]);
        } else {
            // Print answers with no units if no valid units are provided
            printAnswers(value, circle.circleArea(), sphere.sphereArea(), square.squareArea(),
                    cube.cubeArea(), sphere.sphereVolume(), cube.cubeVolume(), "");
        }
    }

    // Method to print the calculated answers
    public static void printAnswers(double value, double circleArea, double sphereArea, double squareArea,
            double cubeArea, double sphereVolume, double cubeVolume, String units) {
        // Print the formatted output for each shape
        System.out.printf("Area of a circle with %.0f %s radius: %.0f %s\n", value, units, circleArea,
                units.isEmpty() ? "" : (units + '\u00b2'));
        System.out.printf("Surface area of a sphere with %.0f %s radius: %.0f %s\n", value, units, sphereArea,
                units.isEmpty() ? "" : (units + '\u00b2'));
        System.out.printf("Area of a square with %.0f %s side: %.0f %s\n", value, units, squareArea,
                units.isEmpty() ? "" : (units + '\u00b2'));
        System.out.printf("Surface area of a cube with %.0f %s side: %.0f %s\n", value, units, cubeArea,
                units.isEmpty() ? "" : (units + '\u00b2'));
        System.out.printf("Volume of a sphere with %.0f %s radius: %.0f %s\n", value, units, sphereVolume,
                units.isEmpty() ? "" : (units + '\u00B3'));
        System.out.printf("Volume of a cube with %.0f %s side: %.0f %s\n", value, units, cubeVolume,
                units.isEmpty() ? "" : (units + '\u00B3'));
    }
}

// Class representing a Circle shape
class Circle {
    private double radius;

    // Constructor to initialize the radius
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate the area of the circle
    public double circleArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

// Class representing a Square shape
class Square {
    private double side;

    // Constructor to initialize the side length
    public Square(double side) {
        this.side = side;
    }

    // Method to calculate the area of the square
    public double squareArea() {
        return Math.pow(side, 2);
    }
}

// Class representing a Sphere shape
class Sphere {
    private double radius;

    // Constructor to initialize the radius
    public Sphere(double radius) {
        this.radius = radius;
    }

    // Method to calculate the surface area of the sphere
    public double sphereArea() {
        return 4 * Math.PI * Math.pow(radius, 2);
    }

    // Method to calculate the volume of the sphere
    public double sphereVolume() {
        return 4 * Math.PI * Math.pow(radius, 3) / 3;
    }
}

// Class representing a Cube shape
class Cube {
    private double side;

    // Constructor to initialize the side length
    public Cube(double side) {
        this.side = side;
    }

    // Method to calculate the surface area of the cube
    public double cubeArea() {
        return 6 * Math.pow(side, 2);
    }

    // Method to calculate the volume of the cube
    public double cubeVolume() {
        return Math.pow(side, 3);
    }
}
