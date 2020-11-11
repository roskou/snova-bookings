package com.snovarent.app.application.services;

import com.snovarent.app.application.domain.DTO.CostDTO;
import com.snovarent.app.application.domain.entities.DiscountEntity;
import com.snovarent.app.application.domain.repositories.DiscountRepository;
import com.snovarent.app.application.factories.DiscountFactory;
import com.snovarent.app.application.models.DiscountModel;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//TODO Calculo de coste de reserva.
// * sabado y domingo 15% mas caro
// * Apartir de 7 dias 10% de descuento

@Service
public class DiscountServiceImplementation implements DiscountService {

    // Repositories & Factories needed ------------------------------
    DiscountRepository repository;
    DiscountFactory factory;

    @Override
    public long getDaysBetweenTwoDates(Date date1, Date date2) {
        return TimeUnit.DAYS.convert((date2.getTime() - date1.getTime()), TimeUnit.MILLISECONDS);
    }


    @Override
    public float calculateCost(CostDTO costData) {

        Date start = new Date(costData.getPreCheckIn().getTime());
        Date end = new Date(costData.getPreCheckOut().getTime());


        long nights = getDaysBetweenTwoDates(start, end);
        long totalPrice = nights * costData.getPrecio();
        System.out.println("night: " + nights + "Precio Hab: " + costData.getPrecio() + "fecha Entrada: " + start + "fecha Salida: " + end + "total: " + totalPrice);
        return totalPrice;
    }

    @Override
    public List<DiscountModel> showAllDiscounts() {
        List<DiscountEntity> entities = repository.findAll();
        List<DiscountModel> models = factory.discountListEntity2Model(entities);
        return models;

    }


    @Override
    public String cuponGenerator() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 8;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        System.out.println(generatedString);
        return generatedString;
    }

//    @Override
//    public double calculateTotalPrice(Date checkIn, Date checkOut, double pricePerNight) {
//        long nights = DateService.getDaysBetweenTwoDates(checkIn, checkOut);
//        double totalPrice = nights * pricePerNight;
//        return totalPrice;
//    }

}
