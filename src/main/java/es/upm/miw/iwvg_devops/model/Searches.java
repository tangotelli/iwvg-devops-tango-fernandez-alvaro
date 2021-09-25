package es.upm.miw.iwvg_devops.model;

import java.util.stream.Collectors;

public class Searches {

    public static Double findFirstDecimalFractionByUserName(String name) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .collect(Collectors.toList())
                .get(0).decimal();
    }
}
