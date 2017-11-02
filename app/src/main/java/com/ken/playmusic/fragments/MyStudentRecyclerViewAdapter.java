package com.ken.playmusic.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import com.ken.playmusic.R;
import com.ken.playmusic.data.entities.Student;
import com.ken.playmusic.fragments.StudentFragment.OnListFragmentInteractionListener;
import com.ken.playmusic.fragments.dummy.DummyContent.DummyItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyStudentRecyclerViewAdapter extends RecyclerView.Adapter<MyStudentRecyclerViewAdapter.ViewHolder>{

    private final List<Student> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final OnItemClickListener listener;


    public MyStudentRecyclerViewAdapter(List<Student> items, OnListFragmentInteractionListener listener, OnItemClickListener listenerItem) {
        mValues = items;
        mListener = listener;
        this.listener = listenerItem;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.render(mValues.get(position));
        holder.bind(mValues.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        @BindView(R.id.Name)
        TextView name;
        @BindView(R.id.School)
        TextView school;
        @BindView(R.id.Age)
        TextView age;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, view);

        }

        void render(Student student) {
            name.setText(student.getName());
            school.setText(student.getSchool());
            age.setText(student.getAge().toString());
        }

        public void bind(final Student item, final OnItemClickListener listener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }

    }

    public interface OnItemClickListener {
        void onItemClick(Student item);
    }
}
