package org.adrianwalker.lg4j;

import java.io.OutputStream;
import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public abstract class XmlRequest<Q> implements Request {

  public final void marshal(final OutputStream os) {

    try {

      JAXBContext context = JAXBContext.newInstance(getClass());
      Marshaller marshaller = context.createMarshaller();
      marshaller.marshal(this, os);

    } catch (final JAXBException jaxbe) {

      throw new DataBindingException(jaxbe);
    }
  }
}
