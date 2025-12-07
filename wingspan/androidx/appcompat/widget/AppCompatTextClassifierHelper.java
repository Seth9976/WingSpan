package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.util.Preconditions;

final class AppCompatTextClassifierHelper {
    private TextClassifier mTextClassifier;
    private TextView mTextView;

    AppCompatTextClassifierHelper(TextView textView0) {
        this.mTextView = (TextView)Preconditions.checkNotNull(textView0);
    }

    public TextClassifier getTextClassifier() {
        TextClassifier textClassifier0 = this.mTextClassifier;
        if(textClassifier0 == null) {
            TextClassificationManager textClassificationManager0 = (TextClassificationManager)this.mTextView.getContext().getSystemService(TextClassificationManager.class);
            return textClassificationManager0 == null ? TextClassifier.NO_OP : textClassificationManager0.getTextClassifier();
        }
        return textClassifier0;
    }

    public void setTextClassifier(TextClassifier textClassifier0) {
        this.mTextClassifier = textClassifier0;
    }
}

