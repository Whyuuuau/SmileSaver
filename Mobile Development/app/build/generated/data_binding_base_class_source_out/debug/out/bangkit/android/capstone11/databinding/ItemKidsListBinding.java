// Generated by view binder compiler. Do not edit!
package bangkit.android.capstone11.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import bangkit.android.capstone11.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ItemKidsListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final CardView cardListKids;

  @NonNull
  public final ImageView ivAvatar;

  @NonNull
  public final TextView tvKidsDataName;

  private ItemKidsListBinding(@NonNull ConstraintLayout rootView, @NonNull CardView cardListKids,
      @NonNull ImageView ivAvatar, @NonNull TextView tvKidsDataName) {
    this.rootView = rootView;
    this.cardListKids = cardListKids;
    this.ivAvatar = ivAvatar;
    this.tvKidsDataName = tvKidsDataName;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ItemKidsListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ItemKidsListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.item_kids_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ItemKidsListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.card_list_kids;
      CardView cardListKids = ViewBindings.findChildViewById(rootView, id);
      if (cardListKids == null) {
        break missingId;
      }

      id = R.id.iv_avatar;
      ImageView ivAvatar = ViewBindings.findChildViewById(rootView, id);
      if (ivAvatar == null) {
        break missingId;
      }

      id = R.id.tv_kids_data_name;
      TextView tvKidsDataName = ViewBindings.findChildViewById(rootView, id);
      if (tvKidsDataName == null) {
        break missingId;
      }

      return new ItemKidsListBinding((ConstraintLayout) rootView, cardListKids, ivAvatar,
          tvKidsDataName);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
