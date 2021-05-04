package org.example.shape.entity;

public class CustomTriangleProperties {
    private double area;
    private double perimeter;


    public CustomTriangleProperties(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public double getArea() {
        return area;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        CustomTriangleProperties triangleProperties = (CustomTriangleProperties) obj;

        boolean flag = this.area == triangleProperties.area
                && this.perimeter == triangleProperties.perimeter;


        return flag;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(area);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(perimeter);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder("CustomTriangleProperties{");
        stringBuilder.append("area=").append(area);
        stringBuilder.append(", perimeter=").append(perimeter);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}
