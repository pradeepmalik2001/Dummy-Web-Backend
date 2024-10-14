package com.web.Service;

import com.web.Entity.Booking;
import com.web.Repository.BookingRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import java.util.List;

@Service
public class BookingService
{
    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    private JavaMailSender javaMailSender;

    public Booking saveUser(Booking booking) throws MessagingException {
        StringBuilder body = new StringBuilder();

        body.append("<html>");
        body.append("<body>");
        body.append("<p>Dear Robert,</p>");
        body.append("<p>The required details of the patient are attached below:</p>");
        body.append("<table border='1' cellpadding='5' cellspacing='0' style='border-collapse: collapse;'>");
        body.append("<thead>");
        body.append("<tr>");
        body.append("<th>Booking ID</th>");
        body.append("<th>Patient Name</th>");
        body.append("<th>Patient Email</th>");
        body.append("<th>Patient Mobile</th>");
        body.append("<th>Patient Address</th>");
        body.append("<th>Booking Date</th>");
        body.append("<th>Type Of Cancer</th>");
        body.append("</tr>");
        body.append("</thead>");
        body.append("<tbody>");
        body.append("<tr>");
        body.append("<td>").append(booking.getId()).append("</td>");
        body.append("<td>").append(booking.getFirstName()).append(" ").append(booking.getLastName()).append("</td>");
        body.append("<td>").append(booking.getEmail()).append("</td>");
        body.append("<td>").append(booking.getMobile()).append("</td>");
        body.append("<td>").append(booking.getAddress()).append(" ").append(booking.getCity()).append(" ").append(booking.getState()).append(" ").append(booking.getPinCode()).append("</td>");
        body.append("<td>").append(booking.getScheduleDate()).append("</td>");
        body.append("<td>").append(booking.getTypeOfCancer()).append("</td>");
        body.append("</tr>");
        body.append("</tbody>");
        body.append("</table>");
        body.append("<p>Thank you!</p>");
        body.append("</body>");
        body.append("</html>");

        String mailTo = booking.getEmail();
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setTo(mailTo);
        helper.setSubject("Regarding Booking Data");
        helper.setText(String.valueOf(body), true); // Set `true` for HTML content

        javaMailSender.send(mimeMessage);
        System.out.println("Email sent successfully to " + mailTo);

        return bookingRepository.save(booking);
    }

    public List<Booking> getAllData()
    {
        return bookingRepository.findAll();
    }
}
