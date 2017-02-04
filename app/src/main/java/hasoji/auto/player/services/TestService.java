package hasoji.auto.player.services;

import android.accessibilityservice.AccessibilityService;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.widget.Toast;

public class TestService extends AccessibilityService {
    private String foregroundPackageName;
    public TestService() {
    }

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            String temp = event.getPackageName().toString();
            if (TextUtils.isEmpty(foregroundPackageName) || !foregroundPackageName.equals(temp)) {
                Toast.makeText(getBaseContext(), temp, Toast.LENGTH_SHORT).show();
                foregroundPackageName = temp;
            }
        }
    }

    @Override
    public void onInterrupt() {

    }


}
