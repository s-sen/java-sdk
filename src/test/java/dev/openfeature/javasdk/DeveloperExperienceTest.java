package dev.openfeature.javasdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import dev.openfeature.javasdk.fixtures.HookFixtures;

import java.util.Arrays;

class DeveloperExperienceTest implements HookFixtures {
    transient String flagKey = "mykey";

    @Test void noProviderSet() {
        final String noOp = "no-op";
        OpenFeatureAPI api = OpenFeatureAPI.getInstance();
        api.setProvider(null);
        Client client = api.getClient();
        String retval = client.getStringValue(flagKey, noOp);
        assertEquals(noOp, retval);
    }

    @Test void simpleBooleanFlag() {
        OpenFeatureAPI api = OpenFeatureAPI.getInstance();
        api.setProvider(new NoOpProvider());
        Client client = api.getClient();
        Boolean retval = client.getBooleanValue(flagKey, false);
        assertFalse(retval);
    }

    @Test void clientHooks() {
        Hook<Boolean> exampleHook = mockBooleanHook();

        OpenFeatureAPI api = OpenFeatureAPI.getInstance();
        api.setProvider(new NoOpProvider());
        Client client = api.getClient();
        client.addHooks(exampleHook);
        Boolean retval = client.getBooleanValue(flagKey, false);
        verify(exampleHook, times(1)).finallyAfter(any(), any());
        assertFalse(retval);
    }

    @Test void evalHooks() {
        Hook<Boolean> clientHook = mockBooleanHook();
        Hook<Boolean> evalHook = mockBooleanHook();

        OpenFeatureAPI api = OpenFeatureAPI.getInstance();
        api.setProvider(new NoOpProvider());
        Client client = api.getClient();
        client.addHooks(clientHook);
        Boolean retval = client.getBooleanValue(flagKey, false, null,
                FlagEvaluationOptions.builder().hook(evalHook).build());
        verify(clientHook, times(1)).finallyAfter(any(), any());
        verify(evalHook, times(1)).finallyAfter(any(), any());
        assertFalse(retval);
    }

    /**
     * As an application author, you probably know special things about your users. You can communicate these to the
     * provider via {@link EvaluationContext}
     */
    @Test void providingContext() {

        OpenFeatureAPI api = OpenFeatureAPI.getInstance();
        api.setProvider(new NoOpProvider());
        Client client = api.getClient();

        EvaluationContext ctx = new EvaluationContext()
                .add("int-val", 3)
                .add("double-val", 4.0)
                .add("str-val", "works")
                .add("bool-val", false)
                .add("value-val", Arrays.asList(new Value(2), new Value(4)));

        Boolean retval = client.getBooleanValue(flagKey, false, ctx);
        assertFalse(retval);
    }

    @Test void brokenProvider() {
        OpenFeatureAPI api = OpenFeatureAPI.getInstance();
        api.setProvider(new AlwaysBrokenProvider());
        Client client = api.getClient();
        FlagEvaluationDetails<Boolean> retval = client.getBooleanDetails(flagKey, false);
        assertEquals("BORK", retval.getErrorCode());
        assertEquals(Reason.ERROR, retval.getReason());
        assertFalse(retval.getValue());
    }
}
