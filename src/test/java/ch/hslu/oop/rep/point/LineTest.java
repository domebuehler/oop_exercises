package ch.hslu.oop.rep.point;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {

    @Test
    public void testForSurprise() {
        Point endPoint = new Point(10, 10);
        Point startPoint = new Point(1, 1);

        Line line = new Line(startPoint, endPoint);

        Point gotStartPoint = line.getStartPoint();
        gotStartPoint.setXValue(2);

        assertThat(gotStartPoint.getXValue()).isNotEqualTo(startPoint.getXValue());
    }

}