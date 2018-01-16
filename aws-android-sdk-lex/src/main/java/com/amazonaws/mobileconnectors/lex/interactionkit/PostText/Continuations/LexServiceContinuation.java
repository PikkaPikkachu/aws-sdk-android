package com.amazonaws.mobileconnectors.lex.interactionkit.PostText.Continuations;

/**
 * Created by prakritibansal on 12/28/17.
 */

import com.amazonaws.mobileconnectors.lex.interactionkit.PostText.InteractionClient;

import java.util.HashMap;
import java.util.Map;

/**
 * <b>Continuations</b>
 * <p>
 * "Continuation"s provide a simple technique to continue with a transaction
 * after a user responds to a prompt from the Amazon Lex service. This
 * encapsulates and provides access to responses from the Amazon Lex service.
 * </p>
 */
public final class LexServiceContinuation{
    // Response from Amazon Lex service.
    private final InteractionClient interactionClient;
    private final Map<String, String> sessionAttributes;

    /**
     * Constructs a continuation for speech request.
     * @param interactionClient {@link InteractionClient}.
     */
    public LexServiceContinuation(InteractionClient interactionClient) {
        this.interactionClient = interactionClient;
        this.sessionAttributes = new HashMap<String, String>();
    }

    /**
     * Returns a specific session attribute.
     * @param attribute the request attribute as a {@link String}.
     * @return the value for the attribute, null if the attribute is not set.
     */
    public String getSessionAttribute(String attribute) {
        return this.sessionAttributes.get(attribute);
    }

    /**
     * Returns all session attributes.
     * @return All session attributes as a {@link Map}.
     */
    public Map<String, String> getSessionAttributes() {
        return this.sessionAttributes;
    }

    /**
     * Replace all session attributes with a new set.
     * @param sessionAttributes {@link Map}.
     */
    public void setSessionAttributes(Map<String, String> sessionAttributes) {
        this.sessionAttributes.clear();
        this.sessionAttributes.putAll(sessionAttributes);
    }

    /**
     * Set value for a specific session attribute, will over-write current value.
     * @param attribute name of the attribute as {@link String}.
     * @param value value of the attribute as {@link String}.
     */
    public void setSessionAttribute(String attribute, String value) {
        sessionAttributes.put(attribute, value);
    }

//    /**
//     * Use this method if the users response is speech. The client will listen to user's input from
//     * the device's microphone. The service will respond to this request with text.
//     */
//    public void continueWithAudioInForTextOut() {
//        interactionClient.audioInForTextOut(sessionAttributes);
//    }
//
//    /**
//     * Use this method if the users response is speech. The client will listen to user's input from
//     * the device's microphone. The service will respond to this request with audio.
//     */
//    public void continueWithAudioInForAudioOut() {
//        interactionClient.audioInForAudioOut(sessionAttributes);
//    }

//    /**
//     * Use this method to respond with text and expect service response with audio.
//     * @param text the response to the prompt as a {@link String}.
//     */
//    public void continueWithTextInForAudioOut(String text) {
//        interactionClient.textInForAudioOut(text, sessionAttributes);
//    }

    /**
     * Use this method to respond with text and expect service response with text.
     * @param text the response to the prompt as a {@link String}.
     */
    public void continueWithTextInForTextOut(String text) {
        interactionClient.textInForTextOut(text, sessionAttributes);
    }

//    /**
//     * Use this method to continue with the current input and output mode.
//     */
//    public void continueWithCurrentMode() {
//        Log.d("SDK", " -- responseMode: " + responseMode + "; requestMode: " + requestMode);
//        if (ResponseType.AUDIO_MPEG.equals(responseMode) && ResponseType.AUDIO_MPEG.equals(requestMode)) {
//            continueWithAudioInForAudioOut();
//        } else {
//            throw new InvalidParameterException(
//                    "Cannot continue with current mode, if request and response are not audio");
//        }
//    }

    /**
     * Use this method to cancel the current transaction.
     */
    public void cancel() {
        interactionClient.cancel();
    }
}

