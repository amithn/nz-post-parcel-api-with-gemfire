//package nz.co.nzpost.parcel.api.security;
//
//import com.gemstone.gemfire.LogWriter;
//import com.gemstone.gemfire.distributed.DistributedMember;
//import com.gemstone.gemfire.security.AuthInitialize;
//import com.gemstone.gemfire.security.AuthenticationFailedException;
//
//import java.util.Properties;
//
//public class UserPasswordAuthInit implements AuthInitialize {
//  public static final String USER_NAME = "security-username";
//  public static final String PASSWORD = "security-password";
//
//  public static AuthInitialize create() {
//    return new UserPasswordAuthInit();
//  }
//
//
//  @Override
//  public void init(LogWriter logWriter, LogWriter logWriter1) throws AuthenticationFailedException {
//
//  }
//
//  public Properties getCredentials(Properties props, DistributedMember server,
//                                   boolean isPeer) throws AuthenticationFailedException {
//
//    Properties newProps = new Properties();
//    newProps.setProperty(USER_NAME,"xxxx");
//    newProps.setProperty(PASSWORD,"xxxx");
//    System.out.println("Return credentials ************");
//    return newProps;
//  }
//
//
//  @Override
//  public void close() {
//
//  }
//}
