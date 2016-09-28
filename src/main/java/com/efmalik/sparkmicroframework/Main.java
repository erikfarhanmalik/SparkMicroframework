package com.efmalik.sparkmicroframework;

import com.efmalik.sparkmicroframework.routes.BookRoutes;
import com.efmalik.sparkmicroframework.routes.PersonRoutes;
import static spark.Spark.*;

public class Main {

    public static void main(String[] args) {
        port(9090);
        new BookRoutes().initRoutes();
        new PersonRoutes().initRoutes();
    }

}
