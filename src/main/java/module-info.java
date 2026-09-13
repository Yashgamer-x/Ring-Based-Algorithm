module com.yashgamerx.ringbasedalgorithm {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.yashgamerx.ringbasedalgorithm to javafx.fxml;
    exports com.yashgamerx.ringbasedalgorithm;
}