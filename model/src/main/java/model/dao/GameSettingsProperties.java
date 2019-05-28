/**
 *
 */
package model.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author Arthur Coppey
 *
 */
public class GameSettingsProperties extends Properties {
    private final static String PROPERTIES_FILE_NAME = "game.properties";
    /**
     *
     */
    private static final long   serialVersionUID     = 1L;
    private int                 mapId;
    
    /**
     *
     */
    public GameSettingsProperties() {
        InputStream inputStream;
        
        inputStream = this.getClass().getClassLoader().getResourceAsStream(GameSettingsProperties.PROPERTIES_FILE_NAME);
        
        if (inputStream != null) {
            try {
                this.load(inputStream);
            }
            catch (final IOException e) {
                e.printStackTrace();
            }
            this.setMapId(this.getProperty("map"));
        }
    }

    public int getMapId() {
        return this.mapId;
    }
    
    /**
     * @param property
     */
    private void setMapId(final String property) {
        this.mapId = Integer.parseInt(property);
    }
    
}
