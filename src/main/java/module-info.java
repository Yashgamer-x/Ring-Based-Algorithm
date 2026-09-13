module com.yashgamerx.ringbasedalgorithm {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires java.logging;


    opens com.yashgamerx.ringbasedalgorithm to javafx.fxml;
    exports com.yashgamerx.ringbasedalgorithm;
}