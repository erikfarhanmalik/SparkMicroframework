package com.efmalik.sparkmicroframework.routes;

import com.efmalik.sparkmicroframework.dao.BaseDao;
import com.efmalik.sparkmicroframework.util.JsonUtils;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.post;
import static spark.Spark.put;

/**
 *
 * @author erik
 */
public class BaseRoutes {

    private String base;
    private BaseDao dao;

    public void initRoutes() {
        get(base + "/", (request, response) -> {
            // Show list data
            return JsonUtils.getInstance().toJson(dao.list());
        });

        get(base, (request, response) -> {
            // Show list data
            return JsonUtils.getInstance().toJson(dao.list());
        });

        get(base + "/:id", (request, response) -> {
            // Show singe data
            return JsonUtils.getInstance().toJson(dao.get(Integer.valueOf(request.params().get(":id"))));
        });

        post(base + "/", (request, response) -> {
            // Create something
            return "{\"status\":\"data saved\"}";
        });

        put(base + "/", (request, response) -> {
            // Update something
            return "{\"status\":\"data updated\"}";
        });

        delete(base + "/", (request, response) -> {
            // Annihilate something
            return "{\"status\":\"data deleted\"}";
        });
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public BaseDao getDao() {
        return dao;
    }

    public void setDao(BaseDao dao) {
        this.dao = dao;
    }

}
