/**
 * Generated class : msg_mission_current
 * DO NOT MODIFY!
 **/
package org.mavlink.messages.ardupilotmega;
import org.mavlink.messages.MAVLinkMessage;
import org.mavlink.IMAVLinkCRC;
import org.mavlink.MAVLinkCRC;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
/**
 * Class msg_mission_current
 * Message that announces the sequence number of the current active mission item. The MAV will fly towards this mission item.
 **/
public class msg_mission_current extends MAVLinkMessage {
  public static final int MAVLINK_MSG_ID_MISSION_CURRENT = 42;
  private static final long serialVersionUID = MAVLINK_MSG_ID_MISSION_CURRENT;
  public msg_mission_current(int sysId, int componentId) {
    messageType = MAVLINK_MSG_ID_MISSION_CURRENT;
    this.sysId = sysId;
    this.componentId = componentId;
    length = 2;
}

  /**
   * Sequence
   */
  public int seq;
/**
 * Decode message with raw data
 */
public void decode(ByteBuffer dis) throws IOException {
  seq = (int)dis.getShort()&0x00FFFF;
}
/**
 * Encode message with raw data and other informations
 */
public byte[] encode() throws IOException {
  byte[] buffer = new byte[8+2];
   ByteBuffer dos = ByteBuffer.wrap(buffer).order(ByteOrder.LITTLE_ENDIAN);
  dos.put((byte)0xFE);
  dos.put((byte)(length & 0x00FF));
  dos.put((byte)(sequence & 0x00FF));
  dos.put((byte)(sysId & 0x00FF));
  dos.put((byte)(componentId & 0x00FF));
  dos.put((byte)(messageType & 0x00FF));
  dos.putShort((short)(seq&0x00FFFF));
  int crc = MAVLinkCRC.crc_calculate_encode(buffer, 2);
  crc = MAVLinkCRC.crc_accumulate((byte) IMAVLinkCRC.MAVLINK_MESSAGE_CRCS[messageType], crc);
  byte crcl = (byte) (crc & 0x00FF);
  byte crch = (byte) ((crc >> 8) & 0x00FF);
  buffer[8] = crcl;
  buffer[9] = crch;
  return buffer;
}
public String toString() {
return "MAVLINK_MSG_ID_MISSION_CURRENT : " +   "  seq="+seq;}
}
