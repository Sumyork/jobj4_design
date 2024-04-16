package ru.job4j.assertj;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isNotEmpty()
                .startsWithIgnoringCase("s")
                .contains("he")
                .isEqualTo("Sphere");
    }

    @Test
    void isThisCube() {
        Box box = new Box(8, 4);
        String name = box.whatsThis();
        assertThat(name).isNotNull()
                .startsWith("C")
                .endsWith("e")
                .isEqualTo("Cube");
    }

    @Test
    void numberOfVertices8() {
        Box box = new Box(8, 9);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isNotZero()
                .isEven()
                .isPositive()
                .isEqualTo(8);
    }

    @Test
    void numberOfVertices0() {
        Box box = new Box(0, 5);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isZero()
                .isGreaterThan(-1)
                .isLessThan(1)
                .isEqualTo(0);
    }

    @Test
    void isExist() {
        Box box = new Box(-1, 10);
        boolean name = box.isExist();
        assertThat(name).isFalse();
    }

    @Test
    void isNotExist() {
        Box box = new Box(8, 7);
        boolean name = box.isExist();
        assertThat(name).isTrue();
    }


    @Test
    void areaSphere() {
        Box box = new Box(0, 5);
        double sphereArea = box.getArea();
        assertThat(sphereArea).isEqualTo(314.15d, withPrecision(0.01d))
                .isGreaterThan(314.15d)
                .isLessThan(314.16d);
    }

    @Test
    void areaTetrahedron() {
        Box box = new Box(4, 3);
        double sphereArea = box.getArea();
        assertThat(sphereArea).isEqualTo(15.59d, withPrecision(0.03d))
                .isBetween(15.0, 16.0)
                .isCloseTo(15.59d, withPrecision(0.01d))
                .isCloseTo(15.59d, Percentage.withPercentage(1.5d));
    }
}