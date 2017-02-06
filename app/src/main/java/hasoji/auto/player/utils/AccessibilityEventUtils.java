package hasoji.auto.player.utils;

/**
 * Created by A on 2017/2/5.
 */

public class AccessibilityEventUtils {
    public static String typeToString(int eventType) {
        switch (eventType) {
            case 16384:
                return "TYPE_ANNOUNCEMENT";
            case 16777216:
                return "TYPE_ASSIST_READING_CONTEXT";
            case 524288:
                return "TYPE_GESTURE_DETECTION_END";
            case 262144:
                return "TYPE_GESTURE_DETECTION_START";
            case 64:
                return "TYPE_NOTIFICATION_STATE_CHANGED";
            case 1024:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_END";
            case 512:
                return "TYPE_TOUCH_EXPLORATION_GESTURE_START";
            case 2097152:
                return "TYPE_TOUCH_INTERACTION_END";
            case 1048576:
                return "TYPE_TOUCH_INTERACTION_START";
            case 32768:
                return "TYPE_VIEW_ACCESSIBILITY_FOCUSED";
            case 65536:
                return "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED";
            case 1:
                return "TYPE_VIEW_CLICKED";
            case 8388608:
                return "TYPE_VIEW_CONTEXT_CLICKED";
            case 8:
                return "TYPE_VIEW_FOCUSED";
            case 128:
                return "TYPE_VIEW_HOVER_ENTER";
            case 256:
                return "TYPE_VIEW_HOVER_EXIT";
            case 2:
                return "TYPE_VIEW_LONG_CLICKED";
            case 4096:
                return "TYPE_VIEW_SCROLLED";
            case 4:
                return "TYPE_VIEW_SELECTED";
            case 16:
                return "TYPE_VIEW_TEXT_CHANGED";
            case 8192:
                return "TYPE_VIEW_TEXT_SELECTION_CHANGED";
            case 131072:
                return "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY";
            case 4194304:
                return "TYPE_WINDOWS_CHANGED";
            case 2048:
                return "TYPE_WINDOW_CONTENT_CHANGED";
            case 32:
                return "TYPE_WINDOW_STATE_CHANGED";
            default:
                return "(unhandled)";
        }
    }
}
