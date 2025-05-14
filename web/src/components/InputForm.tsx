import type { HTMLProps } from "react";
import { twMerge } from "tailwind-merge";

type InputFormProps = HTMLProps<HTMLInputElement>

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
