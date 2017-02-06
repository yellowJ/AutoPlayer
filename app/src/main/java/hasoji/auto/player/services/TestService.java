package hasoji.auto.player.services;

import android.accessibilityservice.AccessibilityService;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import android.widget.Toast;

import java.util.List;

import hasoji.auto.player.utils.AccessibilityEventUtils;

public class TestService extends AccessibilityService {
    private String foregroundPackageName;
    public TestService() {
    }

    private AccessibilityNodeInfo rootNode;

    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo node = event.getSource();
        Log.e("onAccessibilityEvent", "AccessibilityEvent.EventType ==>> " + AccessibilityEventUtils.typeToString(event.getEventType()));
        if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
            rootNode = node;
            String temp = event.getPackageName().toString();
            if (TextUtils.isEmpty(foregroundPackageName) || !foregroundPackageName.equals(temp)) {
                Toast.makeText(getBaseContext(), temp, Toast.LENGTH_SHORT).show();
                foregroundPackageName = temp;
            }
        }

        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {
            Toast.makeText(getBaseContext(), "AccessibilityEvent.TYPE_VIEW_CLICKED", Toast.LENGTH_SHORT).show();
        }

        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_SCROLLED) {
            Log.e("LookAllNode", "AccessibilityEvent.TYPE_VIEW_SCROLLED ==>> " + node.getClassName() + " , " + node.getViewIdResourceName());
        }
        if (node != null) {
            Log.e("LookAllNode", "========== " + foregroundPackageName + " ==========");
            lookAllNode(node);
        }
    }

    private void lookAllNode(AccessibilityNodeInfo node) {
        try {
            int count = node.getChildCount();
            if (count <= 0) {
                if (TextUtils.isEmpty(node.getViewIdResourceName())) {
                    if (TextUtils.isEmpty(node.getText())) {
                        Log.e("LookAllNode", "node.class ==>> " + node.getClassName());
                        if (node.getClassName().toString().contains("ImageButton")) {
//                            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
                            return;
                        }
                    } else {
                        Log.e("LookAllNode", "node.text ==>> " + node.getText());
                    }
                } else {
                    Log.e("LookAllNode", node.getViewIdResourceName());
                }
            } else {
                Log.e("LookAllNode", "node.class ==>> " + node.getClassName());
                for (int i = 0; i < count; i++) {
                    lookAllNode(node.getChild(i));
                }
            }
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onInterrupt() {

    }


}
