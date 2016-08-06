package org.adrianwalker.lg4j;

import java.io.InputStream;
import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public abstract class XmlResponse<S> implements Response {

  public final S unmarshal(final InputStream is) {

    try {

      JAXBContext context = JAXBContext.newInstance(getClass());
      Unmarshaller unmarshaller = context.createUnmarshaller();

      return (S) unmarshaller.unmarshal(is);

    } catch (final JAXBException jaxbe) {

      throw new DataBindingException(jaxbe);
    }
  }
}
