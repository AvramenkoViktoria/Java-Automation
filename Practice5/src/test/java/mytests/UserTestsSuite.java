package mytests;

import org.junit.platform.suite.api.*;

@Suite
@SelectPackages("mytests")
@IncludeTags("user")
public class UserTestsSuite {
}
