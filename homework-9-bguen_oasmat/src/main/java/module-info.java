/**
 * This module provides support for a JavaFX application to display a map of
 * cities and to gradually add edges representing distance to produce a
 * minimum spanning tree.
 */
module cities.model {
    requires javafx.controls;
    requires javafx.fxml;

    opens cities.model to javafx.fxml;
    exports cities.model;
    exports cities.view;
    opens cities.view to javafx.fxml;
    exports cities.controller;
    opens cities.controller to javafx.fxml;
}
