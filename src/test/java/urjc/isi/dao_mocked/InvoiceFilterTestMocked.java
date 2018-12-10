package urjc.isi.dao_mocked;

import static org.junit.Assert.*;


import org.junit.Test;
import static org.mockito.Mockito.*;


import java.util.Arrays;
import java.util.List;

public class InvoiceFilterTestMocked {
    @Test
    public void filterInvoices() {

        Invoice manolo = new Invoice("Manolo", 20.0);
        Invoice sergio = new Invoice("Sergio", 300.0);

        InvoiceDao dao = mock(InvoiceDao.class);

        List<Invoice> results = Arrays.asList(manolo, sergio);
        when(dao.all()).thenReturn(results);

        InvoiceFilter filter = new InvoiceFilter(dao);
        List<Invoice> result = filter.filter();

        assertEquals(manolo, result.get(0));
        assertEquals(1, result.size());
    }

}

