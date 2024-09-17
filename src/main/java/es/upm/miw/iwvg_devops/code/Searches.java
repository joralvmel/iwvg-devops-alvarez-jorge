package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;
import java.util.Optional;

public class Searches {

    public Fraction findHighestFraction() {
        Stream<User> users = new UsersDatabase().findAll();

        Optional<Double> maxValue = users
                .flatMap(user -> user.getFractions().stream())
                .map(Fraction::decimal)
                .filter(decimal -> !decimal.isNaN() && !decimal.isInfinite())
                .max(Double::compareTo);

        return new UsersDatabase().findAll()
                .flatMap(user -> user.getFractions().stream()
                        .filter(fraction -> Math.abs(fraction.decimal() - maxValue.orElse(Double.NaN)) < 1e-9))
                .findFirst()
                .orElse(null);
    }

    public Stream<String> findUserNameBySomeImproperFraction() {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(Fraction::isImproper))
                .map(User::getName)
                .distinct();
    }
}