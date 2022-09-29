/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.candf;

import com.candf.controller.RecommendationController;

import io.javalin.Javalin;

public class CzerniakowskieLakeApplication {

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        RecommendationController controller = new RecommendationController(conf.getClothingRecommendation(),
                                                                           conf.getWeatherClient());
        Javalin application = conf.getApplication().start(8800);

        //application.get("recommendation/{location}", controller::getClothingRecommendation);
        application.get("recommendation/{location}", ctx -> {
            var location = ctx.pathParam("location");
            var result = controller.getClothingRecommendation(location);
            if (!result.equals("")) {
                ctx.status(200).result(result);
            }
            else {
                ctx.status(400).result("Nie można było ustalić rekomendacji");
            }
        });
    }
}
