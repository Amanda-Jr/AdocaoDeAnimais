import type { HTMLProps } from "react";
import { twMerge } from "tailwind-merge";

type InputFormProps = HTMLProps<HTMLInputElement>

type ButtonProps = React.ButtonHTMLAttributes<HTMLButtonElement> & {
  label: string;
};

export function InputForm(props: InputFormProps) {
  return (
    <div className="flex flex-col font-medium">
      <label htmlFor={props.id} className="text-[#C78E00] mt-1.5">
        {props.label}
      </label>
      <input
        {...props}
        className={twMerge("py-3 px-5 bg-[#E5E5E5] rounded-[6px] placeholder:text-black outline-0 mt-[0.25rem]", props.className)}
      />
    </div>
  );
}

export function Button({ label, className, ...rest }: ButtonProps) {
  return (
    <button
      {...rest}
      className={twMerge(
        "bg-[#C78E00] w-3xs text-white font-medium py-5 px-6 rounded-[6px] transition-colors duration-200 hover:bg-[#a97600] disabled:opacity-50 mt-7 self-center",
        className
      )}
    >
      {label}
    </button>
  );
}
