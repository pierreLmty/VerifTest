import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Collections;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * Created by sullivan on 02/12/16.
 */
public class URITest {

// test createGenericURI
//createGenericURI(String scheme, String opaquePart, String fragment)

@test(expected=IllegalArgumentException.class)
public void testCreateGenericURI1()
{
	createGenericURI(null,"valideParam","ValideParam");
}

@test(expected=IllegalArgumentException.class)
public void testCreateGenericURI2()
{
	createGenericURI("valideParam",null,"ValideParam");
}

@test
public void testCreateGenericURI3()
{
	URI result = createGenericURI("valideParam","valideParam","ValideParam");
	assertEquals(result, POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, false, "valideParam", "valideParam", null, false, null, null).appendFragment("valideParam"));
}

@test
public void testCreateGenericURI4()
{
	URI result = createGenericURI("valideParam","valideParam",null);
	assertEquals(result, POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, false, "valideParam", "valideParam", null, false, null, null).appendFragment(null));
}


//createHierarchicalURI(scheme, authority, device, query, fragment)

@test(expected=IllegalArgumentException)
public void testCreateHierarchicalURI1()
{
	createHierarchicalURI("notNull", null, null, "valideParam", "valideParam");
}

@test(expected=IllegalArgumentException)
public void testCreateHierarchicalURI2()
{
	createHierarchicalURI("zip", "valideParam", "valideParam", "valideParam", "valideParam"); // fonctionne avec "jar" ou "archive" a la place de "zip", voir test isArchiveScheme
}

@test
public void testCreateHierarchicalURI3()
{
	String scheme ="valideParam";
	String authority=null;
	String device="valideParam";
	String query="valideParam";
	String fragment="valideParam";
	URI result = createHierarchicalURI(scheme, authority, device, query, fragment);
	assertEquals(result,POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, true, scheme, authority, device, false, NO_SEGMENTS, query).appendFragment(fragment));
}

@test
public void testCreateHierarchicalURI4()
{
	String scheme ="valideParam";
	String authority="valideParam";
	String device=null;
	String query="valideParam";
	String fragment="valideParam";
	URI result = createHierarchicalURI(scheme, authority, device, query, fragment);
	assertEquals(result,POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, true, scheme, authority, device, false, NO_SEGMENTS, query).appendFragment(fragment));
}

@test
public void testCreateHierarchicalURI5()
{
	String scheme ="valideParam";
	String authority="valideParam";
	String device="valideParam";
	String query="valideParam";
	String fragment="valideParam";
	URI result = createHierarchicalURI(scheme, authority, device, query, fragment);
	assertEquals(result,POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, true, scheme, authority, device, false, NO_SEGMENTS, query).appendFragment(fragment));
}

@test
public void testCreateHierarchicalURI6()
{
	String scheme ="valideParam";
	String authority="valideParam";
	String device="valideParam";
	String query=null;
	String fragment="valideParam";
	URI result = createHierarchicalURI(scheme, authority, device, query, fragment);
	assertEquals(result,POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, true, scheme, authority, device, false, NO_SEGMENTS, query).appendFragment(fragment));
}

@test
public void testCreateHierarchicalURI7()
{
	String scheme ="valideParam";
	String authority="valideParam";
	String device="valideParam";
	String query="valideParam";
	String fragment=null;
	URI result = createHierarchicalURI(scheme, authority, device, query, fragment);
	assertEquals(result,POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, true, scheme, authority, device, false, NO_SEGMENTS, query).appendFragment(fragment));
}

//createHierarchicalURI(String scheme, String authority, String device, String[] segments, String query, String fragment)
@test(expected=IllegalArgumentException)
public void testcreateHierarchicalURI1()
{
	String scheme = SCHEME_PLATFORM;
	String authority="validparam";
	String device="notnull";
	String[] segments="validparam";
	String query="validparam";
	String fragment="validparam";
	URI result = createHierarchicalURI( scheme,  authority,  device,  segments,  query,  fragment);
}

@test(expected=IllegalArgumentException)
public void testcreateHierarchicalURI2()
{
	String scheme = "archive"; // <- lance exeception
	String authority="validparam";
	String device="notnull";
	String[] segments="validparam" ???????;
	String query="validparam";
	String fragment="validparam";
	URI result = createHierarchicalURI( scheme,  authority,  device,  segments,  query,  fragment);
}

@test
public void testcreateHierarchicalURI3()
{
	String scheme = "archive";
	String authority="validparam";
	String device=null;
	String[] segments="validparam";
	String query="validparam";
	String fragment="validparam";
	URI result = createHierarchicalURI( scheme,  authority,  device,  segments,  query,  fragment);
	assertEquals(result,POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, true, scheme, authority, device, true, segments, query).appendFragment(fragment));
}

// test createHierarchicalURI(String[] segments, String query, String fragment)

@test
public void testcreateHierarchicalURI3()
{
	String[] segments="validparam";
	String query="validparam";
	String fragment="validparam";
	URI result = createHierarchicalURI(segments,query,fragment);
	assertEquals(result,POOL.intern(false, URIPool.URIComponentsAccessUnit.VALIDATE_ALL, true, scheme, authority, device, true, segments, query).appendFragment(fragment));
}

//test createURI(String uri)
@test
public void testcreateURI()
{
	
}
//test createURI(String uri, boolean ignoreEscaped)

//test createURI(String uri, boolean ignoreEscaped, int fragmentLocationStyle)

//test createDeviceURI(String uri)

//test createURIWithCache(String uri)

//test createFileURI(String pathName)

//test createPlatformResourceURI(String pathName)

//test createPlatformResourceURI(String pathName, boolean encode)

//test createPlatformPluginURI(String pathName, boolean encode)

//test constructeur URI(int hashCode)

//test validateURI(boolean hierarchical, String scheme, String authority, String device, boolean absolutePath, String[] segments, String query, String fragment)

//test validScheme(String value)

//test validOpaquePart(String value)

//test validAuthority(String value)

//test validArchiveAuthority(String value)

//test validJarAuthority(String value)

//test validDevice(String value)

//test validSegment(String value)

//test validSegments(String[] value)

//test firstInvalidSegment(String[] value)

//test validQuery(String value)

//test validFragment(String value)

//test contains(String s, long highBitmask, long lowBitmask)

//test flushCachedString() //donothing

//test cacheString(String string) //donothing

//test getCachedString() //return null
























